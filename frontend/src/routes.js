import React from "react";

import { BrowserRouter, Route, Switch } from "react-router-dom";
import CreateCidadeComponent from "./components/Cidade/CreateCidadeComponent";
import ListCidadeComponent from "./components/Cidade/ListCidadeComponent";
import UpdateCidadeComponent from "./components/Cidade/UpdateCidadeComponent";
import LoginComponent from "./components/Login/LoginComponent";
import MenuComponent from "./components/Login/MenuComponent";
import CreatePassagemComponent from "./components/Passagem/CreatePassagemComponent";
import ListPassagemComponent from "./components/Passagem/ListPassagemComponent";
import CreateRoteiroComponent from "./components/Roteiro/CreateRoteiroComponent";
import ListRoteiroComponent from "./components/Roteiro/ListRoteiroComponent";
import CreateUsuarioComponent from "./components/Usuario/CreateUsuarioComponent";
import ListUsuarioComponent from "./components/Usuario/ListUsuarioComponent";
import UpdateUsuarioComponent from "./components/Usuario/UpdateUsuarioComponent";
import CreateVeiculoComponent from "./components/Veiculo/CreateVeiculoComponent";
import ListVeiculoComponent from "./components/Veiculo/ListVeiculoComponent";
import UpdateVeiculoComponent from "./components/Veiculo/UpdateVeiculoComponent";
import PrivateRoute from "./PrivateRoute";

const Routes = () => (
    <BrowserRouter>
    <Switch>
    <Route path="/" exact component={LoginComponent} />
    </Switch>

    <div >


         <Switch className="container">
            <PrivateRoute path="/menu" component={MenuComponent} />
            <PrivateRoute path="/add-roteiro" component={CreateRoteiroComponent} />
            <PrivateRoute path="/roteiros" component={ListRoteiroComponent} />
            <PrivateRoute path="/passagens" component={ListPassagemComponent} />
            <PrivateRoute path="/add-passagem" component={CreatePassagemComponent} />

         </Switch>
          <Switch>
            <PrivateRoute path="/cidade" component={ListCidadeComponent} />
       <PrivateRoute path="/cidades" component={ListCidadeComponent} />
            <PrivateRoute path="/add-cidade" component={CreateCidadeComponent} />
            <PrivateRoute path="/update-cidade/:id" component={UpdateCidadeComponent} />
          </Switch>

          <Switch>
            <PrivateRoute path="/veiculo" component={ListVeiculoComponent} />
            <PrivateRoute path="/veiculos" component={ListVeiculoComponent} />
            <PrivateRoute path="/add-veiculo" component={CreateVeiculoComponent} />
           <PrivateRoute path="/update-veiculo/:id" component={UpdateVeiculoComponent} />
          </Switch>

          <Switch>
            <PrivateRoute path="/usuarios" component={ListUsuarioComponent} />
           <PrivateRoute path="/add-usuario" component={CreateUsuarioComponent} />
           <PrivateRoute path="/update-usuario/:id" component={UpdateUsuarioComponent} />
        </Switch>
       </div>
    
    </BrowserRouter>
)

export default Routes;