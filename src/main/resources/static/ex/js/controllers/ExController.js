import SingleExView from "../view/SingleExView.js"

import ExModel from "../model/ExModel.js"

const tag = '[ExController]'

export default {
    init(){
        console.log(tag, 'init()')

        SingleExView.setup(document.querySelector('#single-ex'))
            .on('@search' , e => this.onSearch(e.detail.input))


    },

    onSearch(exId){
        console.log(tag, 'onSearch(exId)', exId)
        ExModel.search(exId).then( data =>{
            console.log(data)
            //this.onSearchSuccess(data)
        }).catch(function (err){
            console.log(err)
            //this.onSearchFail(err)
        })
    },

    onSearchSuccess(data){
      console.log(tag, 'onSearchSuccess(data)', data)

    },
    onSearchFail(err){
        console.log(tag, 'onSearchFail(err)', err)
    }

}