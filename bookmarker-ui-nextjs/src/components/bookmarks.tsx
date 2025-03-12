import {BookmarksResponse} from "@/services/models";
import React from "react";
import BookmarkDiv from "@/components/BookmarkDiv";
import Pagination from "@/components/Pagination";

interface BookmarksProps {
    bookmarks: BookmarksResponse
    searchKey?: string
}

const Bookmarks = (props: BookmarksProps) => {
    return(
        <div>
            <Pagination bookmarks={props.bookmarks} searchKey={props.searchKey} />
            {props.bookmarks.data.map((bookmark) => (
                <BookmarkDiv key={bookmark.id} data={bookmark} />
            ))}
        </div>
    );
}

export default Bookmarks;