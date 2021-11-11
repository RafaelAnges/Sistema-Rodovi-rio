
import React, { Component } from 'react'
import UsuarioService from '../../services/UsuarioService';

class UpdateUsuarioComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            id: this.props.match.params.id,
            nome: '',
            cargo: '',
            email: '',
            login: '',
            senha: ''

        }
       this.changeNomeHandler = this.changeNomeHandler.bind(this);
       this.changeCargoHandler = this.changeCargoHandler.bind(this);
       this.changeEmailHandler = this.changeEmailHandler.bind(this);
       this.changeLoginHandler = this.changeLoginHandler.bind(this);
       this.changeSenhaHandler = this.changeSenhaHandler.bind(this);
       this.updateUsuario = this.updateUsuario.bind(this);
    
    }

    componentDidMount() {
        UsuarioService.getUsuarioById(this.state.id).then((res) => {
            let usuario = res.data;
            this.setState({
                nome: usuario.nome,
                cargo: usuario.cargo,
                email: usuario.email,
                login: usuario.login,
                senha: usuario.senha
            });
        });
    }

    updateUsuario = (e) => {
        e.preventDefault();
        let usuario = {nome: this.state.nome, cargo: this.state.cargo, email: this.state.email, login: this.state.login, senha: this.state.senha};
        console.log('usuario => ' + JSON.stringify(usuario));

        
        UsuarioService.createUsuario(usuario, this.state.id).then(res =>{
            this.props.history.push('/usuarios');
        });
    }

   

    changeNomeHandler= (event) => {
        this.setState({nome: event.target.value});
    }

    changeCargoHandler= (event) => {
        this.setState({cargo: event.target.value});
    }

    changeEmailHandler= (event) => {
        this.setState({email: event.target.value});
    }

    changeLoginHandler= (event) => {
        this.setState({login: event.target.value});
    }

    changeSenhaHandler= (event) => {
        this.setState({senha: event.target.value});
    }

    cancel(){
        this.props.history.push('/usuarios');
    }

    render(){
        return(
            <div>
              <div className="container">
                  <div className="row">
                      <div className="card col-md-6 offset-md-3 offset-md-3">
                          <h3 className="text-center">Cadastrar Usuario</h3>
                          <div className="card-body">
                              <form>
                                  <div className="form-group">
                                      <label>Nome: </label>
                                      <input placeholder="Nome" name="nome" className="form-control"
                                       value={this.state.nome} onChange={this.changeNomeHandler}/>
                                  </div>

                                  <div className="form-group">
                                      <label>Cargo: </label>
                                      <input placeholder="Cargo" name="cargo" className="form-control"
                                       value={this.state.cargo} onChange={this.changeCargoHandler}/>
                                  </div>

                                  <div className="form-group">
                                      <label>E-mail: </label>
                                      <input placeholder="Email" name="email" className="form-control"
                                       value={this.state.email} onChange={this.changeEmailHandler}/>
                                  </div>

                                  <div className="form-group">
                                      <label>Login: </label>
                                      <input placeholder="Login" name="login" className="form-control"
                                       value={this.state.login} onChange={this.changeLoginHandler}/>
                                  </div>

                                  <div className="form-group">
                                      <label>Senha: </label>
                                      <input placeholder="Senha" name="senha" className="form-control"
                                       value={this.state.senha} onChange={this.changeSenhaHandler}/>
                                  </div>
                                  <div className="space2"></div>
                                  <button className="btn btn-success" onClick={this.updateUsuario}>Confirmar</button>
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

export default UpdateUsuarioComponent