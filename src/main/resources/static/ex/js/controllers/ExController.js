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
        ExModel.search(exId)
        .then( promiseResponse =>{
            console.log(tag, 'onSearch() promiseResponse',promiseResponse)

            if(promiseResponse.status === 200){
                return promiseResponse.json()
            }else{

            }

        }).then(jsonData =>{
            this.onSearchSuccess(jsonData)
        }).catch(err => {
            console.log(tag, 'onSearch() err', err)
        })
    },

    onSearchSuccess(jsonData){
        console.log(tag, 'onSearchSuccess(jsonData)', jsonData)
        SingleExView.render(jsonData)


    },
    onSearchFail(err){
        console.log(tag, 'onSearchFail(err)', err)
    }

}