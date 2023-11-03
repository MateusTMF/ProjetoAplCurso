<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<div class="container-fluid">

<hl class="h3 mb-2 text-gray-800">Despesas</hl>
<p class="mb-4">Planilha de Registros</p>
<a class="btn btn-success mb-4" href="${pageContext.request.contextPath}/DespesaNovo">
    <i class="fas fa-sticky-note"></i>
    <strong>Novo</strong>
</a>
<div class="card shadow">
     <div class="card-body">
    <table id="datatable" class="display">
        <thead>
            <tr>
                <th align="right">ID</th>
                <th align="left">Descrição</th>
                <th align="center">Data</th>
                <th align="right">ValorDespesa</th>
                <th align="right">ValorPago</th>
                <th Align="center">Excluir</th>
                <th Align="center">Alterar</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="despesa" items="${despesas}">
                <tr>
                    <td align="right">${despesa.iddespesa}</td>
                    <td align="left">${despesa.descricao}</td>
                    <td align="center"><fmt:formatDate pattern = "dd/MM/yyyy" value= "${despesa.datadocumento}"/></td>
                    <td align="right"><fmt:formatNumber value="${despesa.valordespesa}" type="Currency"/></td>
                    <td align="right"><fmt:formatNumber value="${despesa.valorpago}" type="currency"/></td>
                    <td align="Center">
                        <a href="${pageContext.request.contextPath}/DespesaExcluir?iddespesa=${despesa.iddespesa}" id="deletar" title="Excluir" onclick="deletar(${despesa.iddespesa})">
                            <button>Excluir</button>
                        </a>
                    </td>
                    <td align="Center">
                        <a href="${pageContext.request.contextPath}/DespesaCarregar?iddespesa=${despesa.iddespesa}">
                            <button>Alterar</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</div>
</div>
    <script>
        $(document).ready(function(){
            console.log('entrei ready');
            //caregamos a datatable
            //$("#datatable").DataTable({});
            $('#datatable').DataTable({
                "OLanguage": {
                    "sProcessing": "Processando...",
                    "sLengthMenu": "Mostrar _MENU_ registros",
                    "sZeroRecords": "Nenhum registro encontrado.",
                    "sInfo": "Mostrando de _START_ até_END_de_TOTAL_registros",
                    "sInfoEmpty": "Mostrando de 0 até 0 de registros",
                    "sInfoFiltered": "",
                    "sInfoPostFix": "",
                    "sSearch": "Buscar:",
                    "sUrl": "",
                    "oPaginate": {
                        "sFirst": "Primeiro",
                        "sPrevious": "Anterior",
                        "sNext": "Seguinte",
                        "sLast": "Ultimo"
                    }
                }
            });
        });
    function deletar(codigo){
        var id = codigo;
        console.log(codigo);
        Swal.fire({
            title: 'Você tem certeza?',
            text: "Você não podera recuperar depois!",
            icon: 'Warning',
            showCancelbutton: True,
            confirmbuttonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Sim, apague a despesa!',
            cancelButtonText: 'Cancelar'
            }).then((result) => {
            if (result.isConfirmed){
                $.ajax({
                    type: 'post',
                    url: '${pageContext.request.contextPath}/DespesaExcluir',
                    data:{
                        idDespesa: id
            },
            success:
                function(data){
                    if(data==1){
                        Swal.fire({
                            position: 'top-end',
                            icon: 'success',
                            title: 'Sucesso',
                            text: 'Despesa excluida com sucesso!',
                            showConfirmButton: False,
                            timer: 2000
                        })
                    }
                    window.location.href = "${pageContext.request.contextPath}/DespesaListar";
                },
                    error:
                    function(data){
                    window.location.href = "${pageContext.request.contextPath}/DespesaListar";
                }
                });
                };
                });
                }
    </script>
    
<%@ include file="/footer.jsp" %>