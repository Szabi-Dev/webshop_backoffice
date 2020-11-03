import React from 'react';
import { Route, Switch } from "react-router-dom";
import UserTable from '../dataTable/userTable';
import UserPage from '../page/userPage';

export default function SimpleRouter(props){


    return (
    <Switch>
        <Route exact path="/user">
            <UserPage />
        </Route>
        <Route exact path="/privileges">
            <h2>Privileges</h2>
        </Route>

    </Switch> 
    )
}