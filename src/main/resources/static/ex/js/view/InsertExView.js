import View from '../../../common/js/View.js'

const tag = '[InsertExView]'

const InsertExView = Object.create(View)

InsertExView.setup = function (el){
    console.log(tag, 'setup(el)', el)
    this.init(el)
    this.standardCode = el.querySelector('#insert-ex-form #standard-Code')
    this.netIncm = el.querySelector('#insert-ex-form #net-incm')
    this.insertExButtonn = el.querySelector('#insert-ex-form button')

    this.bindEvent();

    return this

}



InsertExView.bindEvent = function (){
    console.log(tag, 'bindEvent(jsonData)')

    this.insertExButtonn.addEventListener('click', e => this.onClickInsertExBtn())

    return this


}

InsertExView.onClickInsertExBtn = function () {
    console.log(tag, 'onClickInsertExBtn()')
    this.emit('@insert', {input: this.standardCode.value})

}


export default InsertExView