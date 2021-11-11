
import React, { Component } from 'react'
import CidadeService from '../../services/CidadeService';

class CreateCidadeComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            cidade: '',
            uf: ''

        }
       this.changeCidadeHandler = this.changeCidadeHandler.bind(this);
       this.changeUfHandler = this.changeUfHandler.bind(this);
       this.saveCidade = this.saveCidade.bind(this);
    
    }

    saveCidade = (e) => {
        e.preventDefault();
        let cidade = {cidade: this.state.cidade, uf: this.state.uf};
        console.log('cidade => ' + JSON.stringify(cidade));

        
        CidadeService.createCidade(cidade).then(res =>{
            this.props.history.push('/cidades');
        });
    }

   

    changeCidadeHandler= (event) => {
        this.setState({cidade: event.target.value});
    }

    changeUfHandler= (event) => {
        this.setState({uf: event.target.value});
    }

    cancel(){
        this.props.history.push('/cidades');
    }

    render(){
        return(
            <div>
              <div className="container">
                  <div className="row">
                      <div className="card col-md-6 offset-md-3 offset-md-3">
                          <h3 className="text-center">Cadastrar Cidade</h3>
                          <div className="card-body">
                              <form>
                                  <div className="form-group">
                                      <label>Cidade: </label>
                                      <input placeholder="Cidade" name="cidade" className="form-control"
                                       value={this.state.cidade} onChange={this.changeCidadeHandler}/>
                                  </div>

                                  <div className="form-group">
                                      <label>Uf: </label>
                                      <input placeholder="Uf" name="uf" className="form-control"
                                       value={this.state.uf} onChange={this.changeUfHandler}/>
                                  </div>
                                  <div className="space2"></div>
                                  <button className="btn btn-success" onClick={this.saveCidade}>Confirmar</button>
                                  <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancelar</button>
                              </form>
                          </div>
                      </div>

                  </div>
              </div>
            </div>
        )
    }
}

export default CreateCidadeComponent