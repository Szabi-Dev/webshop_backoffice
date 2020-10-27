import React from 'react';
import PermanentDrawerLeft from './component/drawer/simpleDrawer';
import { Route, Switch } from "react-router-dom";
import { makeStyles } from '@material-ui/core';

const menu = [
    {id : "user", displayName : "User", link: "/user"},
    {id : "privileges", displayName : "Privileges", link: "/privileges"},
]

const useStyles = makeStyles({
    root : {
        display : 'flex',
    },
})


export default function App () {
    const classes = useStyles()
    
    return (
        <div className={classes.root}>
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
