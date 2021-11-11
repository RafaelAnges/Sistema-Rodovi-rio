import React, { Component } from 'react'

class LoginComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {



        }
    }

    render() {
        return (
            <div class="container">
                <div class="row">
                    <div class="col-md-6-1">

                        <div class="bs-docs-section">

                            <div class="card mb-3">
                                <h3 class="card-header">Login</h3>
                                <div class="card-body">


                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="bs-component">
                                                <form>
                                                    <fieldset>
                                                        <div class="form-group">
                                                            <label for="exampleInputEmail1">Email: *</label>
                                                            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Digite o Email" />
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="exampleInputPassword1">Senha: *</label>
                                                            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" />
                                                        </div>


                                                        <button onclick="window.location.href='home.html'" type="button" class="btn btn-success">Entrar</button>
                                                        

                                                    </fieldset>
                                                </form>
                                            </div>

                                        </div>

                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default LoginComponent