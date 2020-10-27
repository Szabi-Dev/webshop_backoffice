import React from 'react';
import PermanentDrawerLeft from './component/drawer/simpleDrawer';
import { makeStyles } from '@material-ui/core';
import SimpleRouter from './component/router/simpleRouter';

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
            <SimpleRouter/>
        </div>
       
    );
} 
