const tag = '[StockModel]'

export default {
    getStockListByShrIpt(shrIpt){
        console.log(tag, 'search(shrIpt)', shrIpt)
        return fetch('/api/stock/'+shrIpt,{
            method : 'GET',
        }).then(response =>
            response.json().then(data => ({ status : response.status, data : data}))
        ).catch(err => {
            response.json().then(data => ({ data : data}))
        })
    },



}