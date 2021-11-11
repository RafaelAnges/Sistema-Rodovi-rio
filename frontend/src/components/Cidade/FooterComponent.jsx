import React, { Component } from 'react'

class FooterComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            


        }
    }

    render(){
        return(
            <div>
               <footer className="footer">
                   <span className="text-muted">Todos os Direitos Reservados 2021 @RafaelAnges </span>
               </footer>
            </div>
        )
    }
}

export default FooterComponent