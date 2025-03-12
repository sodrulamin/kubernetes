import {Bookmark} from "@/services/models";
import React from "react";
import Link from "next/link";

interface BookmarkProps {
    data: Bookmark
}

const BookmarkDiv = (props: BookmarkProps) => {
    return (
        <div>
            <div className="alert alert-primary" role="alert">
                <h5>
                    <Link href={props.data.url} target={"_blank"} className={"text-decoration-none"}>{props.data.title}</Link>
                </h5>
            </div>
        </div>
    );
}


export default BookmarkDiv;