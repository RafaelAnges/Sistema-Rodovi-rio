
import React from 'react'






function FaturaTable(props){

    
    const rows = props.passagens.map(passagem => {
        return (
            <tr key={passagem.id}>
                <td>{passagem.cidadeDestino}</td>
                <td>{passagem.email}</td>
                <td>{passagem.name}</td>
                <td>{passagem.veiculo}</td>
                <td>{passagem.valor}</td>

                </tr>
                )

    })

  
    


                return (
                <table className="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col">Destino</th>
                            <th scope="col">Mês</th>
                            <th scope="col">Ano</th>
                            <th scope="col">Veiculo</th>
                            <th scope="col">Valor</th>
                        </tr>
                    </thead>
                    <tbody>
                        {rows}
                    </tbody>
                </table>
                )

}

export default FaturaTable













































//import React from 'react'
//import PassagemService from '../../services/PassagemService'

//PassagemService.getPassagens().then((res) => {
 //   this.setState({ passagens: res.data });


//})

//function FaturaTable(props){
//
    //return(
     //   <table className="table table-hover">
    //        <thead>
    //            <tr>
    //                <th scope="col">Destino</th>
                    //<th scope="col">Mês</th>
       //             <th scope="col">Ano</th>
       //             <th scope="col">Veiculo</th>
        //            <th scope="col">Valor</th>
       //             <th scope="col">Opções</th>
          //      </tr>
        //    </thead>
   //     </table>
   // )
//


//export default FaturaTable