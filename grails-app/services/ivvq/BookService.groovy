package ivvq

import grails.transaction.Transactional

@Transactional
class BookService {

    def searchBooks(def params) {
        String stringToSearch = params['stringToSearch']
     if(params.stringToSearch != null){
             stringToSearch = params.stringToSearch
             stringToSearch = stringToSearch.trim()
         }
        def criteria = Book.createCriteria()
        def res = criteria.list (max:params.max,offset:params.offset){
            if (stringToSearch) {
               or {
                   like 'title', "%${stringToSearch}%"
                   like 'isbn13', "%${stringToSearch}%"
                   like 'description', "%${stringToSearch}%"
                   like 'author', "%${stringToSearch}%"
               }
               }
               }
        res
    }
}
