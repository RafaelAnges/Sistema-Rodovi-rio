import axios from 'axios';

const  VEICULO_API_BASE_URL = "http://localhost:8080/api/v1/veiculos";

class VeiculoService {

    getVeiculos() {
        return axios.get(VEICULO_API_BASE_URL);
    }

    createVeiculo(veiculo) {
        return axios.post(VEICULO_API_BASE_URL, veiculo);
    }

    getVeiculoById(veiculoId_v) {
        return axios.get(VEICULO_API_BASE_URL + '/' + veiculoId_v);
    }

    updateVeiculo(veiculo, veiculoId_v) {
        return axios.put(VEICULO_API_BASE_URL + '/' + veiculoId_v, veiculo);
    }

    deleteVeiculo(veiculoId_v){
        return axios.delete(VEICULO_API_BASE_URL + '/' + veiculoId_v);
    }


}

export default new VeiculoService()