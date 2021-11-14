import axios from 'axios';

const ROTEIRO_API_BASE_URL = "http://localhost:8080/api/v1/roteiros";

class RoteiroService {

    getRoteiros() {
        return axios.get(ROTEIRO_API_BASE_URL);
    }

    createRoteiro(roteiro) {
        return axios.post(ROTEIRO_API_BASE_URL, roteiro);
    }

    getRoteiroById(roteiroId) {
        return axios.get(ROTEIRO_API_BASE_URL + '/' + roteiroId);
    }

    updateRoteiro(roteiro, roteiroId) {
        return axios.put(ROTEIRO_API_BASE_URL + '/' + roteiroId, roteiro);
    }

    deleteRoteiro(roteiroId){
        return axios.delete(ROTEIRO_API_BASE_URL + '/' + roteiroId);
    }

    


}

export default new RoteiroService()