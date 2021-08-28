import View from '../../../common/js/View.js'

const tag = '[StckPrcView]'

const StckPrcView = Object.create(View)

StckPrcView.setup = function (el){
    console.log(tag, 'setup(el)', el)
    this.init(el)
    this.myChart = el.querySelector('#myChart');

    this.bindEvent();

    this.onload();
    return this

}



StckPrcView.bindEvent = function (){
    console.log(tag, 'bindEvent()')

    return this


}

StckPrcView.onload = function(e){
    console.log(tag,'onload()')

}


StckPrcView.render = function (jsonData= {}){
    console.log(tag, 'render(jsonData)', jsonData)
    var stockArr = [];
    jsonData.forEach(function (item , idx , arr){stockArr.push({label: item.koreanStockName , value: item.standardCode })})
    this.awesomplete.list = stockArr;
    this.awesomplete.evaluate();


}
export default StckPrcView