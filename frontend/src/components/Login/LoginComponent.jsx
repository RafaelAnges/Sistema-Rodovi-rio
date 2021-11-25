import axios from 'axios';
import React, { Component } from 'react'
import FormGroup from './FormGroup';
import Passo from './Passo';
import { mensagemErro } from '../toastr'

class LoginComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            login: '',
            senha: '',
            mensagemErro: null

        }
    }


    entrar = async () => {
        await axios
        .post('http://localhost:8080/api/v1/usuarios/autenticar', {
            login: this.state.login,
            senha: this.state.senha
        }).then( response => {
            const { data } = response
            if (data) {
                localStorage.setItem('app-token', data)
                this.props.history.push('/menu');
            }
            
            console.log(response)
        }).catch( erro => {

            mensagemErro(erro.response.data)
        })

        
    }

    render() {
        return (
            
            

      <div className="container">
                <div className="row">
                    <div className="col-md-6 offset-md-3 offset-md-3" >
                        <div className="cent">
                        <div className="bs-docs-section">
                            <Passo title="Login">
                                <div className="row">
                                    <span>{this.state.mensagemErro}</span>
                                    <div className="col-lg-12">
                                        <div className="bs-component">
                                            <fieldset>
                                                <FormGroup label="Login: *" htmlFor="exampleInputLogin" >
                                                    <input type="login" className="form-control"
                                                    value={this.state.login}
                                                    onChange={e => this.setState({login: e.target.value})}
                                                    id="exampleInputLogin" aria-describedby="loginHelp"
                                                    placeholder="Digite o Login" />
                                                </FormGroup>
                                                <FormGroup label="Senha: *" htmlFor="exampleInputPassword1">
                                                <input type="password" className="form-control"
                                                    value={this.state.senha}
                                                    onChange={e => this.setState({senha: e.target.value})}
                                                    id="exampleInputPassword1" 
                                                    placeholder="Password" />
                                                </FormGroup>
                                                <button onClick={this.entrar} className="btn btn-success">Entrar</button>

                                            </fieldset>
                                        </div>
                                    </div>
                                </div>

                            </Passo>
                        </div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default LoginComponent