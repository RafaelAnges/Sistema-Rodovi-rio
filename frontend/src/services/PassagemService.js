import axios from 'axios';

const PAISSAGEM_API_BASE_URL = "http://localhost:8080/api/v1/passagens";

class PassagemService {

    getPassagens() {
        return axios.get(PAISSAGEM_API_BASE_URL);
    }

   

    consultar(passagemFiltro) {
        let params = `?name=${passagemFiltro.name}`

        if (passagemFiltro.email) {
            params = `${params}&email=${passagemFiltro.email}`
        }
        return axios.get("http://localhost:8080/api/v1/passagens/filter/custom" + params);
    }

    createPassagem(passagem) {
        return axios.post(PAISSAGEM_API_BASE_URL, passagem);
    }

    getPassagemById(passagemId) {
        return axios.get(PAISSAGEM_API_BASE_URL + '/' + passagemId);
    }

    //updatePassagem(passagem, passagemId) {
    //  return axios.put(PAISSAGEM_API_BASE_URL + '/' + passagemId, passagem);
    //}

    deletePassagem(passagemId) {
        return axios.delete(PAISSAGEM_API_BASE_URL + '/' + passagemId);
    }


}

export default new PassagemService()