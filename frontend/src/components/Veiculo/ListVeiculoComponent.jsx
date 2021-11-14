
import React, { Component } from 'react'
import VeiculoService from '../../services/VeiculoService';

class ListVeiculoComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
            veiculos: []


        }
        this.addVeiculo = this.addVeiculo.bind(this);
        this.editVeiculo = this.editVeiculo.bind(this);
        this.deleteVeiculo = this.deleteVeiculo.bind(this);

    }

    deleteVeiculo(id) {
        VeiculoService.deleteVeiculo(id).then(res => {
            this.setState({ veiculos: this.state.veiculos.filter(veiculo => veiculo.id !== id) });
        });
    }

    editVeiculo(id) {
        this.props.history.push(`/update-veiculo/${id}`);

    }
    componentDidMount() {
        VeiculoService.getVeiculos().then((res) => {
            this.setState({ veiculos: res.data });


        })
    }


    addVeiculo() {
        this.props.history.push('/add-veiculo');
    }


    render() {
        return (
            <div>

                <div >
                    <div className="cor">
                        <div className="topbar">
                            <div className="topbarWrapper">
                                <div className="topLeft">
                                    <span className="logo">Sistema Rodoviario</span>
                                </div>
                                <div className="topRight">
                                    <div className="topbarIconContainer">
                                        <img src="data:image/jpeg;base64,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" alt="" className="topAvatar" />
                                        <span className="cone">Conectado</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div className="container">
                    <h2 className="text-center">Pesquisar Veiculos</h2>
                    <div className="row">
                        <button className="btn btn-primary" onClick={this.addVeiculo}>
                            Cadastrar Veiculo
                        </button>
                        <div className="space"></div>
                    </div>
                    <div className="row">
                        <table className="table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th>Placa</th>
                                    <th>dataCompra</th>
                                    <th>Motorista</th>
                                    <th>Modelo</th>
                                    <th>Poltrona</th>
                                    <th>Opções</th>
                                </tr>
                            </thead>

                            <tbody>
                                {
                                    this.state.veiculos.map(
                                        veiculo =>
                                            <tr key={veiculo.id}>
                                                <td> {veiculo.placa} </td>
                                                <td> {veiculo.dataCompra} </td>
                                                <td> {veiculo.motorista} </td>
                                                <td> {veiculo.modelo} </td>
                                                <td> {veiculo.poltrona} </td>
                                                <td>
                                                    <button onClick={() => this.editVeiculo(veiculo.id)} className="btn btn-info" >Alterar</button>
                                                    <button onClick={() => this.deleteVeiculo(veiculo.id)} className="btn btn-danger" >Delete</button>

                                                </td>

                                            </tr>
                                    )
                                }


                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
        )
    }
}

export default ListVeiculoComponent