import React, { Component } from 'react'

class ListCidadeComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            cidades: []


        }
    }

    render(){
        return(
            <div>
                <h2 className="text-center">Pesquisar Cidades</h2>
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