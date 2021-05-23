const tag = '[ExModel]'

export default {
    search(exId){
        console.log(tag, 'search(exId)', exId)
        return fetch('/ex/'+exId,{
            method : 'GET',
        })
    }
    ,

}