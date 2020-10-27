import React from 'react';
import { Route, Switch } from "react-router-dom";

export default function SimpleRouter(props){


    return (
    <Switch>
        <Route exact path="/user">
            <h2>User</h2>
        </Route>
        <Route exact path="/privileges">
            <h2>Privileges</h2>
        </Route>

    </Switch> 
    )
}