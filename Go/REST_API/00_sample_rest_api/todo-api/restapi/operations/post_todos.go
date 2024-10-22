// Code generated by go-swagger; DO NOT EDIT.

package operations

// This file was generated by the swagger tool.
// Editing this file might prove futile when you re-run the generate command

import (
	"net/http"

	"github.com/go-openapi/runtime/middleware"
)

// PostTodosHandlerFunc turns a function with the right signature into a post todos handler
type PostTodosHandlerFunc func(PostTodosParams) middleware.Responder

// Handle executing the request and returning a response
func (fn PostTodosHandlerFunc) Handle(params PostTodosParams) middleware.Responder {
	return fn(params)
}

// PostTodosHandler interface for that can handle valid post todos params
type PostTodosHandler interface {
	Handle(PostTodosParams) middleware.Responder
}

// NewPostTodos creates a new http.Handler for the post todos operation
func NewPostTodos(ctx *middleware.Context, handler PostTodosHandler) *PostTodos {
	return &PostTodos{Context: ctx, Handler: handler}
}

/*
	PostTodos swagger:route POST /todos postTodos

Create a new ToDo
*/
type PostTodos struct {
	Context *middleware.Context
	Handler PostTodosHandler
}

func (o *PostTodos) ServeHTTP(rw http.ResponseWriter, r *http.Request) {
	route, rCtx, _ := o.Context.RouteInfo(r)
	if rCtx != nil {
		*r = *rCtx
	}
	var Params = NewPostTodosParams()
	if err := o.Context.BindValidRequest(r, route, &Params); err != nil { // bind params
		o.Context.Respond(rw, r, route.Produces, route, err)
		return
	}

	res := o.Handler.Handle(Params) // actually handle the request
	o.Context.Respond(rw, r, route.Produces, route, res)

}
