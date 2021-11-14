import React from 'react';


import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'


import ListCidadeComponent from './components/Cidade/ListCidadeComponent';
import CreateCidadeComponent from './components/Cidade/CreateCidadeComponent';
import UpdateCidadeComponent from './components/Cidade/UpdateCidadeComponent';
import LoginComponent from './components/Login/LoginComponent';
import ListUsuarioComponent from './components/Usuario/ListUsuarioComponent';
import CreateUsuarioComponent from './components/Usuario/CreateUsuarioComponent';
import UpdateUsuarioComponent from './components/Usuario/UpdateUsuarioComponent';
import MenuComponent from './components/Login/MenuComponent';
import CreateRoteiroComponent from './components/Roteiro/CreateRoteiroComponent';
import ListRoteiroComponent from './components/Roteiro/ListRoteiroComponent';


function App() {
  return (

    <div>
      <Router>
      <Switch>
              <Route path="/login" exact component={LoginComponent} />
      </Switch>
     
      
          <div >

  
            <Switch className="container">
              <Route path="/menu" component={MenuComponent} />
              <Route path="/add-roteiro" exact component={CreateRoteiroComponent} />
              <Route path="/roteiros" exact component={ListRoteiroComponent} />

            </Switch>
            <Switch>
              <Route path="/cidade" exact component={ListCidadeComponent} />
              <Route path="/cidades" component={ListCidadeComponent} />
              <Route path="/add-cidade" component={CreateCidadeComponent} />
              <Route path="/update-cidade/:id" component={UpdateCidadeComponent} />
            </Switch>

            <Switch>
              <Route path="/" exact component={ListUsuarioComponent} />
              <Route path="/usuarios" component={ListUsuarioComponent} />
              <Route path="/add-usuario" component={CreateUsuarioComponent} />
              <Route path="/update-usuario/:id" component={UpdateUsuarioComponent} />
            </Switch>
          </div>
      </Router>
    </div>


  );
}

export default App;
