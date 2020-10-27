import React from 'react';
import PermanentDrawerLeft from './component/drawer/simpleDrawer';
import { Route, Switch } from "react-router-dom";

const menu = [
    {id : "user", displayName : "User", link: "/user"},
    {id : "privileges", displayName : "Privileges", link: "/privileges"},

]

export default function App () {
    return (
        <div>
            <PermanentDrawerLeft menu={menu} />
            <Switch>
                <Route exact path="/user">
                    <h2>User</h2>
                </Route>
                <Route exact path="/privileges">
                    <h2>Privileges</h2>
                </Route>

            </Switch>
        </div>
       
    );
} 
