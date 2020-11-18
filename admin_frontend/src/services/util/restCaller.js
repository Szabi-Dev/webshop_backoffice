
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

    const makeRequest = async (actionLink, action='GET', payload='') => {
        defaultOptions.method = action
        if (action != 'GET'){
            defaultOptions.body = JSON.stringify(payload)
        }
        return defaultFetch(actionLink, defaultOptions)
    }

    const defaultFetch = async (actionLink, options) => {
        let response;
        try {
            response = await fetch(actionLink, options);
        } catch(ex) {
            console.log(ex)
            return 
        }
        if (!response.ok){
            console.log(response)
            return 
        }
        console.log(response)
        return await response.json();
    }

    return {
        makeRequest
    }
}
