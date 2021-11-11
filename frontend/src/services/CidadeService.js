import axios from 'axios';

const CIDADE_API_BASE_URL = "http://localhost:8080/api/v1/cidades";

class CidadeService {

    getCidades() {
        return axios.get(CIDADE_API_BASE_URL);
    }

    createCidade(cidade) {
        return axios.post(CIDADE_API_BASE_URL, cidade);
    }

    getCidadeById(cidadeId) {
        return axios.get(CIDADE_API_BASE_URL + '/' + cidadeId);
    }

    updateCidade(cidade, cidadeId) {
        return axios.put(CIDADE_API_BASE_URL + '/' + cidadeId, cidade);
    }

    deleteCidade(cidadeId){
        return axios.delete(CIDADE_API_BASE_URL + '/' + cidadeId);
    }

    


}

export default new CidadeService()