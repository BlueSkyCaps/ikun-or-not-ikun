
let env:string = "prod"

const apiUris= ()=>{
    return {
        "dev":{
            "proxy":"http://localhost",
            "uris":{
                "distinguish": "/ikun/distinguish",
            }
        },
        "prod":{
            "proxy":"http://localhost",
            "uris":{
                "distinguish": "/ikun/distinguish",
            }
        }
    }[env]
}

export {
    apiUris
}