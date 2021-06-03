import View from '../../../common/js/View.js'

const tag = '[StockView]'

const StockView = Object.create(View)

StockView.setup = function (el){
    console.log(tag, 'setup(el)', el)
    this.init(el)
    this.shrIpt = el.querySelector('#shrIpt')
    this.shrBtn = el.querySelector('#shrBtn')
    this.awesomplete = new Awesomplete(this.shrIpt, {
        list: [],
        minChars: 1
    });
    this.bindEvent();

    return this

}



StockView.bindEvent = function (){
    console.log(tag, 'bindEvent()')

    this.shrBtn.addEventListener('click', e => this.onClickShrBtn(e))
    this.shrIpt.addEventListener('keyup', e => this.onKeyupShrIpt(e))

    return this


}
/**
 * 검색버튼 클릭 or input에서 엔터시 실행
 *  */
StockView.onClickShrBtn = function (){
    console.log(tag, 'onClickShrBtn()')
    this.emit('@search', {input: this.shrIpt.value})
}

/**
 * input에서 입력시 autoComplete
 *  */
StockView.onKeyupShrIpt = function (e){
    console.log(tag, 'onKeyupShrIpt()')
    const enter = 13
    if (this.shrIpt.value.length === 0) return;

    if (e.keyCode === enter) this.emit('@search', {input: this.shrIpt.value})
    else {
        this.emit('@autoComplete', {input: this.shrIpt.value})
    }
}

StockView.render = function (jsonData= {}){
    console.log(tag, 'render(jsonData)', jsonData)
    var stockArr = [];
    jsonData.forEach(function (item , idx , arr){stockArr.push(item.koreanStockName)})
    this.awesomplete.list = stockArr;
    this.awesomplete.evaluate();
}

export default StockView