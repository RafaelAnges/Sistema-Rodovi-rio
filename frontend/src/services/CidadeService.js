import axios from 'axios';

const CIDADE_API_BASE_URL = "http://localhost:8080/api/v1/cidades";

class CidadeService {

    getCidades() {
        return axios.get(CIDADE_API_BASE_URL);
    }

    createCidade(cidade) {
        return axios.post(CIDADE_API_BASE_URL, cidade);
    }

    getCidadeById(cidadeId_v) {
        return axios.get(CIDADE_API_BASE_URL + '/' + cidadeId_v);
    }

    updateCidade(cidade, cidadeId_v) {
        return axios.put(CIDADE_API_BASE_URL + '/' + cidadeId_v, cidade);
    }

    deleteCidade(cidadeId_v){
        return axios.delete(CIDADE_API_BASE_URL + '/' + cidadeId_v);
    }

    


}

export default new CidadeService()