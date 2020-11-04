import React from 'react';
import { Route, Switch } from "react-router-dom";
import PrivilegePage from '../page/privilegePage';
import RolePage from '../page/rolePage';
import UserPage from '../page/userPage';

export default function SimpleRouter(props){


    return (
    <Switch>
        <Route exact path="/user">
            <UserPage />
        </Route>
        <Route exact path="/role">
            <RolePage />
        </Route>
        <Route exact path="/privilege">
            <PrivilegePage />
        </Route>
    </Switch> 
    )
}