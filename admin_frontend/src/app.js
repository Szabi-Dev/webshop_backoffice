import React from 'react';
import PermanentDrawerLeft from './component/drawer/simpleDrawer';
import { makeStyles } from '@material-ui/core';
import SimpleRouter from './component/router/simpleRouter';

const useStyles = makeStyles({
    root : {
        display : 'flex',
    },
})


export default function App () {
    const classes = useStyles()
    
    return (
        <div className={classes.root}>
            <PermanentDrawerLeft />
            <SimpleRouter/>
        </div>
       
    );
} 
