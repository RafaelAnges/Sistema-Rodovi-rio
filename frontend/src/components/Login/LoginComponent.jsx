import React, { Component } from 'react'
import FormGroup from './FormGroup';
import Passo from './Passo';


class LoginComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            login: '',
            senha: ''


        }
    }

    entrar = () => {
        console.log('Login: ', this.state.login)
        console.log('Senha: ', this.state.senha)
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