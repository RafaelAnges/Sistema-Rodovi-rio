import axios from 'axios';

const  VEICULO_API_BASE_URL = "http://localhost:8080/api/v1/veiculos";

class VeiculoService {

    getVeiculos() {
        return axios.get(VEICULO_API_BASE_URL);
    }

    createVeiculo(veiculo) {
        return axios.post(VEICULO_API_BASE_URL, veiculo);
    }

    getVeiculoById(veiculoId) {
        return axios.get(VEICULO_API_BASE_URL + '/' + veiculoId);
    }

    updateVeiculo(veiculo, veiculoId) {
        return axios.put(VEICULO_API_BASE_URL + '/' + veiculoId, veiculo);
    }

    deleteVeiculo(veiculoId){
        return axios.delete(VEICULO_API_BASE_URL + '/' + veiculoId);
    }


}

export default new VeiculoService()