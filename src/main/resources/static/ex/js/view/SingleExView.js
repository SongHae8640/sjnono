import View from './View.js'

const tag = '[SingleExView]'

const SingleExView = Object.create(View)

SingleExView.setup = function (el){
    console.log(tag, 'setup(el)', el)
    this.init(el)
    this.exId = el.querySelector(".request-ex-id")
    this.searchBtn = el.querySelector(".search-btn")
    this.responseExId = el.querySelector(".response-ex-id")
    this.responseStockContent = el.querySelector(".response-stock-content")


    //element querySelector


    this.bindEvent()

    return this
}

SingleExView.bindEvent = function (){
    console.log(tag, 'bindEvent()')
    this.searchBtn.addEventListener('click', e => this.onClickSearchBtn())

}

SingleExView.onClickSearchBtn = function () {
    console.log(tag, 'onClickSearchBtn()')
    this.emit('@search', {input: this.exId.value})

}
export default SingleExView

