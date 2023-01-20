package rest.example

import grails.rest.RestfulController

//tag::controller[]
import groovy.transform.CompileStatic

@CompileStatic
class ProductController extends RestfulController {
    ProductController() {
        super(Product)
    }
    ProductService productService
    def search(String q, Integer max ) {
        if (q) {
            respond productService.findByNameLike("%${q}%".toString(), [max: Math.min( max ?: 10, 100)]) // <3>
        }
        else {
            respond([])
        }
    }
}
