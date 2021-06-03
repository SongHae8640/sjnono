import StockView from "../view/StockView.js"

import StockModel from "../model/StockModel.js"

const tag = '[StockController]'

export default {
    init(){
        console.log(tag, 'init()')

        StockView.setup(document.querySelector('#stockForm'))
            .on('@search' , e => this.onSearch(e.detail.input))
            .on('@autoComplete' , e => this.onAutoComplete(e.detail.input))

    },

    onSearch(shrVal) {
        console.log(shrVal);

    },

    onAutoComplete(shrVal){
        console.log(shrVal);
        StockModel.getStockListByShrIpt(shrVal)
            .then( response =>{
                console.log(tag, 'getStockListByShrIpt() response', response)

                if(response.status ===201){
                    StockView.render(response.data)
                }else{
                    this.connectionError(response.data)
                }
            })
    },

    connectionError(error){
        console.log(tag,'connectionError(error)', error)
    },

}