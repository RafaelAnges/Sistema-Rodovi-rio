
import React, { Component } from 'react'
import CidadeService from '../../services/CidadeService';

class ListCidadeComponent extends Component {
    
    constructor(props){
        super(props)

        this.state = {
            cidades: []


        }
        this.addCidade = this.addCidade.bind(this);
        this.editCidade = this.editCidade.bind(this);
        this.deleteCidade = this.deleteCidade.bind(this);
       
    }

    deleteCidade(id){
        CidadeService.deleteCidade(id).then( res => {
            this.setState({cidades: this.state.cidades.filter(cidade => cidade.id !== id)});
        });
    }

    editCidade(id){
        this.props.history.push(`/update-cidade/${id}`);

    }
    componentDidMount(){
        CidadeService.getCidades().then((res) => {
            this.setState({ cidades: res.data});
            

        })
    }


    addCidade(){
        this.props.history.push('/add-cidade');
    }
    

    render(){
        return(
            <div>
                <h2 className="text-center">Pesquisar Cidades</h2>
                <div className="row">
                    <button className="btn btn-primary" onClick={this.addCidade}>
                        Cadastrar Cidade
                    </button>
                    <div className="space"></div>
                    </div>
                    <div className="row">
                    <table className="table table-striped table-bordered">

                        <thead>
                            <tr>
                                <th>Cidade</th>
                                <th>Uf</th>
                                <th>Opções</th>
                            </tr>
                        </thead>

                        <tbody>
                            {
                                this.state.cidades.map(
                                    cidade =>
                                    <tr key = {cidade.id}>
                                        <td> {cidade.cidade} </td>
                                        <td> {cidade.uf} </td>
                                        <td>
                                            <button onClick = { () => this.editCidade(cidade.id)} className="btn btn-info" >Alterar</button>
                                            <button onClick = { () => this.deleteCidade(cidade.id)} className="btn btn-danger" >Delete</button>
                                        
                                        </td>

                                    </tr>
                                )
                            }


                        </tbody>
                    </table>
                </div>
            
            </div>
        )
    }
}

export default ListCidadeComponent