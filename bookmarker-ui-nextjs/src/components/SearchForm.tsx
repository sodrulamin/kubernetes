import React, {useState} from "react";
import { useRouter } from "next/router";


const SearchForm = () => {
    const router = useRouter();
    const [query, setQuery] = useState("");

    const handleSearch = async (e: React.SyntheticEvent) => {
        e.preventDefault();
        if(query.trim().length > 0) {
            await router.push(`/bookmarks?page=1&query=${query}`);
            return;
        }

        await router.push(`/bookmarks`);
    }

    return (
        <div className={"pb-3"}>
            <form method={"get"} onSubmit={handleSearch}>
                <div className="row g-3 align-items-center">
                    <div className="col">
                        <input className={"form-control"}
                                type={"search"}
                                value={query}
                                onChange={(e) => setQuery(e.target.value)}/>
                    </div>
                    <div className="col-auto">
                        <button type={"submit"} className={"btn btn-primary"}>Search</button>
                    </div>
                </div>
            </form>
        </div>
    );
}


export default SearchForm;