const tag = '[ExModel]'

export default {
    search(exId){
        console.log(tag, 'search(exId)', exId)
        return fetch('/ex/'+exId,{
            method : 'GET',
        })
        // .then(response => {
        //     console.log(tag, 'search() Promise response', response)
        //     return response.json()
        // })
        // .then(jsonData =>{
        //     console.log(tag, 'search() jsonData', jsonData)
        //     return jsonData
        // })
        // .catch(err =>{
        //     console.log(tag, 'search() err', err)
        //     return err
        // })
    }
    ,

}