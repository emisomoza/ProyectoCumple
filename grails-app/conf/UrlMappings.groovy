class UrlMappings {

	static mappings = {
		"/empleadorest"(resources: "EmpleadoRest")
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
