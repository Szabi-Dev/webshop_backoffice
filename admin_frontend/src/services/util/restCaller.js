import {BACKEND_BASE_URI} from './constants'


export const RestCaller = () => {

    const defaultHeaders = {
        'Content-Type': 'application/json'
    }

    const defaultOptions = {
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'same-origin', // include, *same-origin, omit
        headers: defaultHeaders,
        redirect: 'follow', // manual, *follow, error
        referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
    }

    const getRequest = async (apiString) =>{
        defaultOptions.method = 'GET'
        return defaultFetch(apiString, defaultOptions)
        
    }


    const defaultFetch = async (apiString, options) => {
        let response;
        try {
            response = await fetch(BACKEND_BASE_URI + apiString, options);
        } catch(ex) {
            console.log(ex)
            return 
        }
        if (!response.ok){
            console.log(response)
            return 
        }

        return await response.json();
    }

    return {
        getRequest
    }
}
