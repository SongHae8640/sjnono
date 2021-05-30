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



    onSearch(exId){
        console.log(tag, 'onSearch(exId)', exId)
        ExModel.getExById(exId)
        .then( response  =>{
            console.log(tag, 'onSearch() response',response)

            if(response.status === 200){    // OK
                this.onSearchSuccess(response.data)
            }else if(response.status === 204){  //No Content
                this.onSearchFailNoContent(response.data)
            }else{  //서버와의 연결이 안될 때(응답상태코드 X)
                this.connectionError(response.data)
            }

        })
    },

    getExList(page = 0){
        console.log(tag, 'getExList()')
        ExModel.getExList(page)
        .then( response =>{
            console.log(tag, 'getExList() response',response)

            if(response.status === 200){
                MultiExView.render(response.data)
            }else{
                this.connectionError(response.data)
            }

        })
    },

    insertEx(standardCode){
        console.log(tag, 'insertEx(standardCode)', standardCode)
        ExModel.insertEx(standardCode)
            .then( response =>{
                console.log(tag, 'insertEx() response',response)

                if(response.status === 200){
                    this.onInsertExSuccess(response.data)
                }else{
                    this.connectionError(response.data)
                }
            })
    },



    onSearchFailNoContent(err){
        console.log(tag, 'onSearchFailNoContent(err)', err)
    },

    connectionError(error){
        console.log(tag,'connectionError(error)', error)
    },

    onSearchSuccess(exData){
        console.log(tag, 'onSearchSuccess(jsonData)', exData)
        SingleExView.render(exData)
    },

    onInsertExSuccess(jsonData){
        this.onSearchSuccess(jsonData)
    },

}