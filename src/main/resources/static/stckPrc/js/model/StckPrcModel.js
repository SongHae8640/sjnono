const tag = '[StckPrcModel]'
export default {

    getStockPrcList(standardCode){
        console.log(tag, 'search(shrIpt)', standardCode)
        return fetch('/api/stckPrc/'+standardCode,{
            method : 'GET',
        }).then(response =>
            response.json().then(data => ({ status : response.status, data : data}))
        ).catch(err => {
            response.json().then(data => ({ data : data}))
        })
    }


}