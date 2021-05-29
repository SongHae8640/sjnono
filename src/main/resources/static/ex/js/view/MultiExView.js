import View from './View.js'

const tag = '[MultiExView]'

const MultiExView = Object.create(View)

MultiExView.setup = function (el){
    console.log(tag, 'setup(el)', el)
    this.init(el)
    this.multiExTableBody = el.querySelector('#multi-ex-table tbody')
    this.multiExTableRowTemplate = el.querySelector('#multi-ex-table .multi-ex-table-row-template')

    this.pagination = el.querySelector("#multi-ex-page-nav .pagination")
    this.prevPageTemplate = el.querySelector('#multi-ex-page-nav .page-item-template.prevPage')
    this.numPageTemplate = el.querySelector('#multi-ex-page-nav .page-item-template.numPage')
    this.nextPageTemplate = el.querySelector('#multi-ex-page-nav .page-item-template.nextPage')


    return this

}



MultiExView.render = function (jsonData){
    console.log(tag, 'render(jsonData)', jsonData)
    this.multiExTableBody.innerHTML = ''
    this.pagination.innerHTML = ''

    jsonData.content.forEach(exElement => this.addExRow(exElement))

    var tempPage
    if(!jsonData.first){
        tempPage = this.prevPageTemplate.cloneNode(true)
        tempPage.style.display = ''
        tempPage.setAttribute('data-page', jsonData.number -1 )
        this.pagination.innerHTML = this.pagination.innerHTML + tempPage.outerHTML

    }

    for (var idx = 0 ; idx < jsonData.totalPages ; idx ++){
        tempPage = this.numPageTemplate.cloneNode(true)
        tempPage.style.display = ''
        tempPage.setAttribute('data-page', idx )
        tempPage.querySelector('a').innerText = (idx+1)
        this.pagination.innerHTML = this.pagination.innerHTML + tempPage.outerHTML
    }

    if(!jsonData.last){
        tempPage = this.nextPageTemplate.cloneNode(true)
        tempPage.style.display = ''
        tempPage.setAttribute('data-page',jsonData.number + 1 )
        this.pagination.innerHTML = this.pagination.innerHTML + tempPage.outerHTML

    }

    MultiExView.bindPageClickEvent()

    return this


}

MultiExView.bindPageClickEvent = function (){
    Array.from(this.pagination.querySelectorAll('li')).forEach( li =>{
        li.addEventListener('click', e => this.onClickPage(e))
    })
}

MultiExView.onClickPage = function (e){
    const {page} = e.currentTarget.dataset
    console.log(tag, 'onClickPage() {page}', {page})
    this.emit('@clickPage', {page})
}


MultiExView.addExRow = function (element) {
    console.log(tag,'addExRow(element)', element)
    var tempAddExRow = this.multiExTableRowTemplate.cloneNode(true)
    tempAddExRow.classList.remove('multi-ex-table-row-template')
    tempAddExRow.style.display = ''
    tempAddExRow.querySelector('.multi-ex-table-row-id').textContent = element.id
    tempAddExRow.querySelector('.multi-ex-table-row-stock-name').textContent = element.stock.koreanStockShortName

    this.multiExTableBody.innerHTML = this.multiExTableBody.innerHTML + tempAddExRow.innerHTML


}

export default MultiExView