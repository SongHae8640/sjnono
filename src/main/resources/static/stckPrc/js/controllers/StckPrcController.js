import StckPrcView from "../view/StckPrcView.js"

import StckPrcModel from "../model/StckPrcModel.js"

const tag = '[StckPrcController]'

export default {
    init() {
        console.log(tag, 'init()')

        StckPrcView.setup(document.querySelector('#content'))
            .on('@onload', e => this.onload(e))

    },

    onload(e){
        StckPrcModel.getStockPrcList()
            .then( response =>{

                if(response.status ===201){
                    StckPrcView.render(response.data)
                }else{
                    this.connectionError(response.data)
                }
            })
    }


}