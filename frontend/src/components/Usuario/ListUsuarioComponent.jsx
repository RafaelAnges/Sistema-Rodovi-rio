
import React, { Component } from 'react'
import UsuarioService from '../../services/UsuarioService';

class ListUsuarioComponent extends Component {
    
    constructor(props){
        super(props)

        this.state = {
            usuarios: []


        }
        this.addUsuario = this.addUsuario.bind(this);
        this.editUsuario = this.editUsuario.bind(this);
        this.deleteUsuario = this.deleteUsuario.bind(this);
    }

    deleteUsuario(id){
        UsuarioService.deleteUsuario(id).then( res => {
            this.setState({usuarios: this.state.usuarios.filter(usuario => usuario.id !== id)});
        });
    }

    editUsuario(id){
        this.props.history.push(`/update-usuario/${id}`);

    }
    componentDidMount(){
        UsuarioService.getUsuarios().then((res) => {
            this.setState({ usuarios: res.data});
            

        })
    }


    addUsuario(){
        this.props.history.push('/add-usuario');
    }
    

    render(){
        return(
            <div>
                <h2 className="text-center">Pesquisar Usuarios</h2>
                <div className="row">
                    <button className="btn btn-primary" onClick={this.addUsuario}>
                        Cadastrar Usuario
                    </button>
                    <div className="space"></div>
                    </div>
                    <div className="row">
                    <table className="table table-striped table-bordered">

                        <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Cargo</th>
                                <th>E-mail</th>
                                <th>Login</th>
                                <th>Senha</th>
                            </tr>
                        </thead>

                        <tbody>
                            {
                                this.state.usuarios.map(
                                    usuario =>
                                    <tr key = {usuario.id}>
                                        <td> {usuario.nome} </td>
                                        <td> {usuario.cargo} </td>
                                        <td> {usuario.email} </td>
                                        <td> {usuario.login} </td>
                                        <td> {usuario.senha} </td>
                                        <td>
                                            <button onClick = { () => this.editUsuario(usuario.id)} className="btn btn-info" >Alterar</button>
                                            <button onClick = { () => this.deleteUsuario(usuario.id)} className="btn btn-danger" >Delete</button>
                                        
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

export default ListUsuarioComponent