import {BookmarksResponse} from "@/services/models";
import React from "react";
import Link from "next/link";

interface PaginationProps {
    bookmarks: BookmarksResponse
    searchKey?: string
}

const Pagination = (props: PaginationProps) => {

    const path = "/bookmarks";
    const queryParams = (props.searchKey === undefined || props.searchKey === "") ? {} : {query: props.searchKey};
    const firstPage = {pathname: path, query: {page: 1, ...queryParams}}
    const lastPage = {pathname: path, query: {page: props.bookmarks.totalPages, ...queryParams}}
    const prevPage = {pathname: path, query: {page: props.bookmarks.currentPage - 1, ...queryParams}}
    const nextPage = {pathname: path, query: {page: props.bookmarks.currentPage + 1, ...queryParams}}

    // console.log("path: " + path + " firstPage: " + firstPage + " lastPage: " + lastPage + " prevPage: "
    //     + prevPage + " nextPage: " + nextPage + " hasPrevious: " + props.bookmarks.hasPrev
    //     + " hasNext: " + props.bookmarks.hasNext);

    return (
        <div>
            <nav aria-label="Page navigation">
                <ul className={"pagination justify-content-center"}>
                    <li className={"page-item " + (props.bookmarks.hasPrev ? "" : "disabled")}>
                        <Link href={firstPage} className={"page-link"}>
                            First
                        </Link>
                    </li>
                    <li className={"page-item " + (props.bookmarks.hasPrev ? "" : "disabled")}>
                        <Link href={prevPage} className={"page-link"}>
                            Previous
                        </Link>
                    </li>
                    <li className={"page-item " + (props.bookmarks.hasNext ? "" : "disabled")}>
                        <Link href={nextPage} className={"page-link"}>
                            Next
                        </Link>
                    </li>
                    <li className={"page-item " + (props.bookmarks.hasNext ? "" : "disabled")}>
                        <Link href={lastPage} className={"page-link"}>
                            Last
                        </Link>
                    </li>
                </ul>
            </nav>
        </div>
    );
}

export default Pagination;