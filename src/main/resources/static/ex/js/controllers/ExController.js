import SingleExView from "../view/SingleExView.js"
import MultiExView from "../view/MultiExView.js"
import InsertExView from "../view/InsertExView.js"

import ExModel from "../model/ExModel.js"

const tag = '[ExController]'

export default {
    init(){
        console.log(tag, 'init()')

        SingleExView.setup(document.querySelector('#single-ex'))
            .on('@search' , e => this.onSearch(e.detail.input))

        MultiExView.setup(document.querySelector('#multi-ex'))
            .on('@clickPage', e=> this.getExList(e.detail.page))

        InsertExView.setup(document.querySelector('#insert-ex-form'))
            .on('@insert', e=>this.insertEx(e.detail.input))

        this.getExList()


    },
    insertEx(standardCode){
        console.log(tag, 'insertEx(standardCode)', standardCode)
        ExModel.insertEx(standardCode)
        .then( promiseResponse =>{
                console.log(tag, 'insertEx() promiseResponse',promiseResponse)

                if(promiseResponse.status === 200){
                    return promiseResponse.json()
                }else{

                }

            }).then(jsonData =>{
            this.onInsertExSuccess(jsonData)
        }).catch(err => {
            console.log(tag, 'onSearch() err', err)
        })
    },
    onInsertExSuccess(jsonData){
        this.onSearchSuccess(jsonData)
    }

    ,

    onSearch(exId){
        console.log(tag, 'onSearch(exId)', exId)
        ExModel.getExById(exId)
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
    },

    getExList(page = 0){
        console.log(tag, 'getExList()')
        ExModel.getExList(page)
        .then( promiseResponse =>{
            console.log(tag, 'getExList() promiseResponse',promiseResponse)

            if(promiseResponse.status === 200){
                return promiseResponse.json()
            }else{

            }

        }).then(jsonData =>{
            MultiExView.render(jsonData)
        }).catch(err => {
            console.log(tag, 'getExList() err', err)
        })
    },

}