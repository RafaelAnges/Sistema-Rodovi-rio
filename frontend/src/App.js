import React from 'react';


import './App.css';
import { BrowserRouter as Router, Route, Switch  } from 'react-router-dom'
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';


import ListCidadeComponent from './components/ListCidadeComponent';
import CreateCidadeComponent from './components/CreateCidadeComponent';


function App() {
  return (
    <div>
      <Router>
        <div className="container">
          <HeaderComponent />
          <div className="container">
            <Switch>
              <Route path = "/" exact component = {ListCidadeComponent}/>
              <Route path = "/cidades" component = {ListCidadeComponent }/>
              <Route path = "/add-cidade" component = {CreateCidadeComponent}/>
              <ListCidadeComponent/>
            </Switch>
          </div>
          <FooterComponent />
        </div>
    </Router>
    </div>


  );
}

export default App;
